package au.com.roadhouse.rxdbflow.sql.language;

import com.raizlabs.android.dbflow.sql.Query;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.OrderBy;
import com.raizlabs.android.dbflow.sql.language.SQLCondition;
import com.raizlabs.android.dbflow.sql.language.Where;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.structure.Model;

/**
 * Defines the where clause of a SQL query
 */
public class RxWhere<TModel extends Model> extends BaseModelQueriableObservable<TModel>
        implements Query, RxTransformable<TModel> {

    Where<TModel> mRealWhere;

    RxWhere(Where<TModel> where) {
        super(where);
        mRealWhere = where;
    }

    /**
     * Adds a param to the WHERE clause with the custom {@link SQLCondition}
     *
     * @param condition The {@link SQLCondition} to use
     * @return  An instance of RxWhere
     */
    public RxWhere<TModel> and(SQLCondition condition){
        mRealWhere.and(condition);

        return this;
    }

    /**
     * Constructs a where clause which contains all of the passed in conditions
     *
     * @param conditions The conditions to add to the where clause
     * @return An instance of RxWhere
     */
    public RxWhere<TModel> andAll(SQLCondition[] conditions) {
        mRealWhere.andAll(conditions);
        return this;
    }

    @Override
    public String getQuery() {
        return mRealWhere.getQuery();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RxWhere<TModel> groupBy(NameAlias... nameAliases) {
        mRealWhere.groupBy(nameAliases);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RxWhere<TModel> groupBy(IProperty... properties) {
        mRealWhere.groupBy(properties);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RxWhere<TModel> orderBy(NameAlias nameAlias, boolean ascending) {
        mRealWhere.orderBy(nameAlias, ascending);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RxWhere<TModel> orderBy(IProperty property, boolean ascending) {
        mRealWhere.orderBy(property, ascending);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RxWhere<TModel> orderBy(OrderBy orderBy) {
        mRealWhere.orderBy(orderBy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RxWhere<TModel> limit(int count) {
        mRealWhere.limit(count);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RxWhere<TModel> offset(int offset) {
        mRealWhere.offset(offset);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RxWhere<TModel> having(SQLCondition... conditions) {
        mRealWhere.having(conditions);
        return this;
    }
}
