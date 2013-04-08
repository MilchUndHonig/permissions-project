package mhsoft.permissions.entity.metamodel;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;

import mhsoft.permissions.entity.RolePermission;

import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QRolePermission is a Querydsl query type for RolePermission
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRolePermission extends EntityPathBase<RolePermission> {

    private static final long serialVersionUID = -1121775843;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QRolePermission rolePermission = new QRolePermission("rolePermission");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> changeDate = _super.changeDate;

    //inherited
    public final StringPath changeUser = _super.changeUser;

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    public final BooleanPath createPermission = createBoolean("createPermission");

    //inherited
    public final StringPath createUser = _super.createUser;

    public final BooleanPath deletePermission = createBoolean("deletePermission");

    public final BooleanPath editPermission = createBoolean("editPermission");

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final BooleanPath locked = _super.locked;

    public final QPermission permission;

    public final BooleanPath readPermission = createBoolean("readPermission");

    public final QRole role;

    public QRolePermission(String variable) {
        this(RolePermission.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QRolePermission(Path<? extends RolePermission> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRolePermission(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRolePermission(PathMetadata<?> metadata, PathInits inits) {
        this(RolePermission.class, metadata, inits);
    }

    public QRolePermission(Class<? extends RolePermission> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.permission = inits.isInitialized("permission") ? new QPermission(forProperty("permission")) : null;
        this.role = inits.isInitialized("role") ? new QRole(forProperty("role")) : null;
    }

}

