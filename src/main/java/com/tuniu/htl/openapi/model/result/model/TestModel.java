package com.tuniu.htl.openapi.model.result.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
public class TestModel implements Serializable {

    @Size(min = 2, max = 4)
    private List<Integer> things;


}
