package com.zhitar.xml.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@XmlRootElement(name = "exchange")
@XmlAccessorType(XmlAccessType.FIELD)
public class Exchange implements Serializable {
    private static final long serialVersionUID = 1L;
    @XmlElement(name = "currency")
    private List<Currency> currencies = new ArrayList<>();
}
