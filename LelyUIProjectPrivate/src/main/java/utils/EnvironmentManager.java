package utils;

public class EnvironmentManager {

    public static String getUrlForEnvironment(String environment) {
        return switch (environment.toLowerCase()) {
            case "lely", "prod" -> EnvironmentConstants.PROD_URL;
            case "dev" -> EnvironmentConstants.DEV_URL;
            case "test" -> EnvironmentConstants.TEST_URL;
            case "techdocs" -> EnvironmentConstants.TECHDOCS_URL;
            default -> throw new IllegalArgumentException("Unknown environment: " + environment);
        };
    }
}
