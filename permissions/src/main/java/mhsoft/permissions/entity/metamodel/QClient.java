package mhsoft.permissions.entity.metamodel;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;

import mhsoft.permissions.entity.Client;
import mhsoft.permissions.entity.UserClient;

import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QClient is a Querydsl query type for Client
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QClient extends EntityPathBase<Client> {

    private static final long serialVersionUID = -272223229;

    public static final QClient client = new QClient("client");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> changeDate = _super.changeDate;

    //inherited
    public final StringPath changeUser = _super.changeUser;

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    //inherited
    public final StringPath createUser = _super.createUser;

    public final BooleanPath defaultClient = createBoolean("defaultClient");

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final BooleanPath locked = _super.locked;

    public final StringPath name = createString("name");

    public final SetPath<UserClient, QUserClient> userClients = this.<UserClient, QUserClient>createSet("userClients", UserClient.class, QUserClient.class, PathInits.DIRECT);

    public QClient(String variable) {
        super(Client.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QClient(Path<? extends Client> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QClient(PathMetadata<?> metadata) {
        super(Client.class, metadata);
    }

}

