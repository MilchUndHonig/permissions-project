package mhsoft.permissions.entity.metamodel;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;

import mhsoft.permissions.entity.UserClientRole;

import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QUserClientRole is a Querydsl query type for UserClientRole
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUserClientRole extends EntityPathBase<UserClientRole> {

    private static final long serialVersionUID = -686204604;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QUserClientRole userClientRole = new QUserClientRole("userClientRole");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> changeDate = _super.changeDate;

    //inherited
    public final StringPath changeUser = _super.changeUser;

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    //inherited
    public final StringPath createUser = _super.createUser;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final BooleanPath locked = _super.locked;

    public final QRole role;

    public final QUserClient userClient;

    public QUserClientRole(String variable) {
        this(UserClientRole.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QUserClientRole(Path<? extends UserClientRole> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUserClientRole(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUserClientRole(PathMetadata<?> metadata, PathInits inits) {
        this(UserClientRole.class, metadata, inits);
    }

    public QUserClientRole(Class<? extends UserClientRole> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.role = inits.isInitialized("role") ? new QRole(forProperty("role")) : null;
        this.userClient = inits.isInitialized("userClient") ? new QUserClient(forProperty("userClient"), inits.get("userClient")) : null;
    }

}

