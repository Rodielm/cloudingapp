package es.uv.twcam.cloudingreactive.collection;



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


    private String _id;
    private Integer avgTime;


}