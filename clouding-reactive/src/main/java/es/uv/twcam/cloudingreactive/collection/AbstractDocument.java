package es.uv.twcam.cloudingreactive.collection;

import org.springframework.data.annotation.Id;

import lombok.Data;

/**
 * AbstractDocument
 */
@Data
public class AbstractDocument<T> {

    @Id
    private T documentId;
}