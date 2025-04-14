package com.kh.boot.domain.vo;


import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Attachment {

    private int fileNo;
    private int refBoardNo;
    private String originName;
    private String changeName;
    private String filePath;
    private String uploadDate;
    private int fileLevel;
    private String status;
}
