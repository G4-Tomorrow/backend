package com.server.wordwaves.dto.response.vocabulary;

import com.server.wordwaves.dto.response.common.BaseAuthorResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TopicResponse extends BaseAuthorResponse {
    String id;
    String name;
    String thumbnailName;
}