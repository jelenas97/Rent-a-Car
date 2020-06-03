package com.rentCar.dto;

import com.rentCar.model.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {
    private Long id;
    private LocalDate date;
    private String content;
    private String status;
    private Long advertisement_id;
    private Long client_id;
    private Long rent_request_id;


    public CommentDTO(Comment comment){
        this.id = comment.getId();
        this.date = comment.getDate();
        this.content = comment.getContent();
        this.status = comment.getStatus().toString();
        this.advertisement_id = comment.getAdvertisement().getId();
        this.client_id = comment.getUser().getId();
        this.rent_request_id= comment.getRentRequest().getId();
    }
}
