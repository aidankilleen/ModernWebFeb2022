package ie.pt.graphqlhelloworld;

import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;

@Configuration
public class GraphQlConfig {

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    UserResolver userResolver;

    @Bean
    public GraphQLSchema getGraphQlSchema() {

        // load the schema file and turn it into a
        // GraphQLSchema object

        SchemaParser schemaParser = new SchemaParser();
        SchemaGenerator schemaGenerator = new SchemaGenerator();

        Resource resource = null;
        File schemaFile = null;
        TypeDefinitionRegistry registry = null;

        try {
            resource = resourceLoader.getResource("classpath:schema.graphqls");
            schemaFile = resource.getFile();
            registry = schemaParser.parse(schemaFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // connect the schema queries with the Java objects
        // that will handle those queries (Resolvers)
        RuntimeWiring wiring = RuntimeWiring.newRuntimeWiring()
                .type("Queries", builder ->
                        builder.dataFetcher("users", userResolver))
                .build();

        // return the schema
        return schemaGenerator.makeExecutableSchema(registry, wiring);

    }
}
