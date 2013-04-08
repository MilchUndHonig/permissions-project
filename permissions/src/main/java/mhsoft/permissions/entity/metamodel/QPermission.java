package mhsoft.permissions.entity.metamodel;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;

import mhsoft.permissions.entity.Permission;
import mhsoft.permissions.entity.RolePermission;

import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPermission is a Querydsl query type for Permission
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPermission extends EntityPathBase<Permission> {

    private static final long serialVersionUID = 424552967;

    public static final QPermission permission = new QPermission("permission");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final BooleanPath admin = createBoolean("admin");

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

    public QPermission(String variable) {
        super(Permission.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QPermission(Path<? extends Permission> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QPermission(PathMetadata<?> metadata) {
        super(Permission.class, metadata);
    }

}

