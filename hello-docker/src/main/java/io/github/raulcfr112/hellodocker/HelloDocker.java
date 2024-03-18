package io.github.raulcfr112.hellodocker;

public class HelloDocker {

    private final String content;
    private final String environment;

    public HelloDocker(String content, String environment) {
        this.content = content;
        this.environment = environment;
    }

    public String getContent() {
        return content;
    }

    public String getEnvironment() {
        return environment;
    }
}
