package es.uv.twcam.cloudingreactive.collection;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * StoreControl
 */

@Document(collection = "storeControl")
@TypeAlias("store_control")
@Data
public class StoreControl extends AbstractDocument<ObjectId> {

    private String aeropuertoId;
    private String reservationId;
    private String storeId;
    private List<Double> spend;
    private Date paymentDate;

}