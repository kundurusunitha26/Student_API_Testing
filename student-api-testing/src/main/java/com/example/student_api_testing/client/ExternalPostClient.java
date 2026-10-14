package com.example.student_api_testing.client;

import com.example.student_api_testing.model.ExternalPost;
import java.util.List;

public interface ExternalPostClient {
	
	List <ExternalPost> fetchPosts();
}