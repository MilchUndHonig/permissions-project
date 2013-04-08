package mhsoft.permissions.entity.metamodel;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;

import mhsoft.permissions.entity.AbstractEntity;

import com.mysema.query.types.Path;


/**
 * QAbstractEntity is a Querydsl query type for AbstractEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAbstractEntity extends EntityPathBase<AbstractEntity> {

    private static final long serialVersionUID = -820500771;

    public static final QAbstractEntity abstractEntity = new QAbstractEntity("abstractEntity");

    public final DateTimePath<java.util.Date> changeDate = createDateTime("changeDate", java.util.Date.class);

    public final StringPath changeUser = createString("changeUser");

    public final DateTimePath<java.util.Date> createDate = createDateTime("createDate", java.util.Date.class);

    public final StringPath createUser = createString("createUser");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath locked = createBoolean("locked");

    public QAbstractEntity(String variable) {
        super(AbstractEntity.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QAbstractEntity(Path<? extends AbstractEntity> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QAbstractEntity(PathMetadata<?> metadata) {
        super(AbstractEntity.class, metadata);
    }

}

