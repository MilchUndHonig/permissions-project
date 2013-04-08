package mhsoft.permissions.entity.metamodel;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;

import mhsoft.permissions.entity.UserClient;
import mhsoft.permissions.entity.UserClientRole;

import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QUserClient is a Querydsl query type for UserClient
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUserClient extends EntityPathBase<UserClient> {

    private static final long serialVersionUID = 2068573102;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QUserClient userClient = new QUserClient("userClient");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> changeDate = _super.changeDate;

    //inherited
    public final StringPath changeUser = _super.changeUser;

    public final QClient client;

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    //inherited
    public final StringPath createUser = _super.createUser;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final BooleanPath locked = _super.locked;

    public final QUser user;

    public final SetPath<UserClientRole, QUserClientRole> userClientRoles = this.<UserClientRole, QUserClientRole>createSet("userClientRoles", UserClientRole.class, QUserClientRole.class, PathInits.DIRECT);

    public QUserClient(String variable) {
        this(UserClient.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QUserClient(Path<? extends UserClient> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUserClient(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUserClient(PathMetadata<?> metadata, PathInits inits) {
        this(UserClient.class, metadata, inits);
    }

    public QUserClient(Class<? extends UserClient> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.client = inits.isInitialized("client") ? new QClient(forProperty("client")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

