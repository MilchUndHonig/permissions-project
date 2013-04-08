package mhsoft.permissions.entity.metamodel;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;

import mhsoft.permissions.entity.Role;
import mhsoft.permissions.entity.RolePermission;
import mhsoft.permissions.entity.UserClientRole;

import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QRole is a Querydsl query type for Role
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRole extends EntityPathBase<Role> {

    private static final long serialVersionUID = 111898286;

    public static final QRole role = new QRole("role");

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

    public final StringPath name = createString("name");

    public final SetPath<RolePermission, QRolePermission> rolePermissions = this.<RolePermission, QRolePermission>createSet("rolePermissions", RolePermission.class, QRolePermission.class, PathInits.DIRECT);

    public final SetPath<UserClientRole, QUserClientRole> userClientRoles = this.<UserClientRole, QUserClientRole>createSet("userClientRoles", UserClientRole.class, QUserClientRole.class, PathInits.DIRECT);

    public QRole(String variable) {
        super(Role.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QRole(Path<? extends Role> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QRole(PathMetadata<?> metadata) {
        super(Role.class, metadata);
    }

}

