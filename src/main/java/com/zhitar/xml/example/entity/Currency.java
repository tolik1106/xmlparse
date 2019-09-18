package com.zhitar.xml.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhitar.xml.example.XmlDateAdapter;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static com.zhitar.xml.example.XmlDateAdapter.DATE_PATTERN;

@Entity
@Data
@NoArgsConstructor
@ToString
@XmlRootElement(name = "currency")
@XmlAccessorType(XmlAccessType.FIELD)
public class Currency implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @XmlElement(name = "r030")
    private Integer code;
    @XmlElement(name = "txt")
    private String name;
    @XmlElement(name = "rate")
    private BigDecimal value;
    @XmlElement(name = "cc")
    private String stringCode;
    @XmlElement(name = "exchangedate")
    @XmlJavaTypeAdapter(XmlDateAdapter.class)
    @JsonFormat(pattern = DATE_PATTERN)
    private Date date;
}