package com.app.dtos;

//Importing required classes
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetailDTO {
 private String recipient;
 private String msgBody;
 private String subject;
 private String attachment;
}
