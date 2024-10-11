package com.server.wordwaves.dto.response.vocabulary;

import java.time.Instant;

import com.server.wordwaves.dto.response.common.BaseAuthorResponse;
import com.server.wordwaves.dto.response.common.BaseResponse;
import com.server.wordwaves.entity.vocabulary.WordCollectionCategory;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WordCollectionResponse extends BaseAuthorResponse {
    String id;
    String name;
    String thumbnailName;
    WordCollectionCategory wordCollectionCategory;
}
