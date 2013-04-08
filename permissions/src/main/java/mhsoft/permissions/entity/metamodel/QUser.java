package mhsoft.permissions.entity.metamodel;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;

import mhsoft.permissions.entity.User;
import mhsoft.permissions.entity.UserClient;

import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 111991299;

    public static final QUser user = new QUser("user");

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

    public final SetPath<UserClient, QUserClient> userClients = this.<UserClient, QUserClient>createSet("userClients", UserClient.class, QUserClient.class, PathInits.DIRECT);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QUser(Path<? extends User> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata<?> metadata) {
        super(User.class, metadata);
    }

}

