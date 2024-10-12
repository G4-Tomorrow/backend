package com.server.wordwaves.service;

import com.server.wordwaves.dto.request.vocabulary.WordCreationRequest;
import com.server.wordwaves.dto.response.common.PaginationInfo;
import com.server.wordwaves.dto.response.vocabulary.WordResponse;

import java.util.List;

public interface WordService {
    WordResponse create(WordCreationRequest request);

    PaginationInfo<List<WordResponse>> getWords(int pageNumber, int pageSize, String sortBy, String sortDirection, String searchQuery);
}
