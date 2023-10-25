package com.mily.article.milyx;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMilyX is a Querydsl query type for MilyX
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMilyX extends EntityPathBase<MilyX> {

    private static final long serialVersionUID = -33569408L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMilyX milyX = new QMilyX("milyX");

    public final com.mily.user.QMilyUser author;

    public final com.mily.board.QBoard board;

    public final StringPath body = createString("body");

    public final StringPath createDate = createString("createDate");

    public final com.mily.article.milyx.category.entity.QFirstCategory firstCategory;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath modifyDate = createString("modifyDate");

    public final com.mily.article.milyx.category.entity.QSecondCategory secondCategory;

    public final StringPath subject = createString("subject");

    public QMilyX(String variable) {
        this(MilyX.class, forVariable(variable), INITS);
    }

    public QMilyX(Path<? extends MilyX> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMilyX(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMilyX(PathMetadata metadata, PathInits inits) {
        this(MilyX.class, metadata, inits);
    }

    public QMilyX(Class<? extends MilyX> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.author = inits.isInitialized("author") ? new com.mily.user.QMilyUser(forProperty("author")) : null;
        this.board = inits.isInitialized("board") ? new com.mily.board.QBoard(forProperty("board")) : null;
        this.firstCategory = inits.isInitialized("firstCategory") ? new com.mily.article.milyx.category.entity.QFirstCategory(forProperty("firstCategory")) : null;
        this.secondCategory = inits.isInitialized("secondCategory") ? new com.mily.article.milyx.category.entity.QSecondCategory(forProperty("secondCategory"), inits.get("secondCategory")) : null;
    }

}

