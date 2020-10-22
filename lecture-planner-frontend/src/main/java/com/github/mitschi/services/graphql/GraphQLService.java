package com.github.mitschi.services.graphql;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mitschi.models.Employee;
import com.github.mitschi.models.Lecture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;

@Service
public class GraphQLService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${endpoint.graphql}")
    private String graphqlEndpointUrl;

    public GraphQLService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
        objectMapper = new ObjectMapper();
    }

    public void addEmployee(Employee e) {
        GraphQLQuery query = new GraphQLQuery();
        query.setQuery(
                "mutation create($input: EmployeeInput!){\n" +
                "  createEmployee(input: $input) {\n" +
                "    id\n" +
                "  }\n" +
                "}"
        );
        query.setVariables(
                Collections.singletonMap("input", EmployeeInput.fromEmployee(e))
        );
        restTemplate.postForEntity(graphqlEndpointUrl, query, Object.class);
    }

    public void addLecture(Lecture l) {
        GraphQLQuery query = new GraphQLQuery();
        query.setQuery(
                "mutation create($input: LectureInput!) {\n" +
                "  createLecture(input: $input) {\n" +
                "    id\n" +
                "  }\n" +
                "}"
        );
        query.setVariables(
                Collections.singletonMap("input", LectureInput.fromLecture(l))
        );
        restTemplate.postForEntity(graphqlEndpointUrl, query, Object.class);
    }

    public Employee[] getEmployees() {
        GraphQLQuery query = new GraphQLQuery();
        query.setQuery(
               "{\n" +
               "  employees {\n" +
               "    id\n" +
               "    name\n" +
               "    employeeNumber\n" +
               "  }\n" +
               "}\n"
        );

        // Result has GraphQL JSON format -> unpack and convert back to Employee[]
        ResponseEntity<JsonNode> response = restTemplate.postForEntity(graphqlEndpointUrl, query, JsonNode.class);
        JsonNode employeesJson = response.getBody().get("data").get("employees");

        Employee[] employees = null;
        try {
            employees = objectMapper.readValue(employeesJson.toString(), Employee[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public Lecture[] getLectures() {
        GraphQLQuery query = new GraphQLQuery();
        query.setQuery(
                "{\n" +
                "  lectures {\n" +
                "    id\n" +
                "    name\n" +
                "    number\n" +
                "    lecturer {\n" +
                "      id\n" +
                "      name\n" +
                "      employeeNumber\n" +
                "    }\n" +
                "  }\n" +
                "}\n"
        );

        // Result has GraphQL JSON format -> unpack and convert back to Lecture[]
        ResponseEntity<JsonNode> response = restTemplate.postForEntity(graphqlEndpointUrl, query, JsonNode.class);
        JsonNode lectureJson = response.getBody().get("data").get("lectures");

        Lecture[] lectures = null;
        try {
            lectures = objectMapper.readValue(lectureJson.toString(), Lecture[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lectures;
    }
}
