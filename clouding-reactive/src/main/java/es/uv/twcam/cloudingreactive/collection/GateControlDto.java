package es.uv.twcam.cloudingreactive.collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GateControlDto
 */
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GateControlDto {

    private static final long serialVersionUID = 1L;

    private String _id;
    private Integer avgTime;


}