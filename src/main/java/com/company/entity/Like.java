package com.company.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Like {
    private int id;
    private int likerId;
    private int likedId;
}
