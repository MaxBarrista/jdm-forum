package com.barrista.jdm.forum.controller;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Message
{
    @Id
    private Long id;
    private String text;
}
