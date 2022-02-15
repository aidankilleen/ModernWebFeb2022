package ie.pt.graphqlhelloworld;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserResolver implements DataFetcher<List<User>> {

    @Override
    public List<User> get(DataFetchingEnvironment environment) {

        User u1 = new User(1, "Alice", "alice@gmail.com", false);
        User u2 = new User(2, "Bob", "bob@gmail.com", true);

        return Arrays.asList(u1, u2);
    }
}
