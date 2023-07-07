package edu.devcci.justpractice.service;

import org.kohsuke.github.GitHub;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GithubService {

    public GitHub getGitHubConnect() throws IOException {
        return GitHub.connect();
    }
}
