package com.xzinoviou.myplayground.error;

import lombok.*;

/**
 * @author : Xenofon Zinoviou
 */
@Builder
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaygroundAppError {

    private int status;

    private String message;

    private String timestamp;
}
