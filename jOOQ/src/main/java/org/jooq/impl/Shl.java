/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Other licenses:
 * -----------------------------------------------------------------------------
 * Commercial licenses for this work are available. These replace the above
 * ASL 2.0 and offer limited warranties, support, maintenance, and commercial
 * database integrations.
 *
 * For more information, please visit: http://www.jooq.org/licenses
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.jooq.impl;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.Internal.*;
import static org.jooq.impl.Keywords.*;
import static org.jooq.impl.Names.*;
import static org.jooq.impl.SQLDataType.*;
import static org.jooq.impl.Tools.*;
import static org.jooq.impl.Tools.BooleanDataKey.*;
import static org.jooq.impl.Tools.DataExtendedKey.*;
import static org.jooq.impl.Tools.DataKey.*;
import static org.jooq.SQLDialect.*;

import org.jooq.*;
import org.jooq.Record;
import org.jooq.conf.*;
import org.jooq.impl.*;
import org.jooq.tools.*;

import java.util.*;


/**
 * The <code>SHL</code> statement.
 */
@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
final class Shl<T extends Number>
extends
    AbstractField<T>
{

    private final Field<T>                value;
    private final Field<? extends Number> count;

    Shl(
        Field<T> value,
        Field<? extends Number> count
    ) {
        super(
            N_SHL,
            allNotNull((DataType) dataType(INTEGER, value, false), value, count)
        );

        this.value = nullSafeNotNull(value, INTEGER);
        this.count = nullSafeNotNull(count, INTEGER);
    }

    // -------------------------------------------------------------------------
    // XXX: QueryPart API
    // -------------------------------------------------------------------------

    @Override
    public final void accept(Context<?> ctx) {
        switch (ctx.family()) {






            case FIREBIRD:
                ctx.visit(function(N_BIN_SHL, getDataType(), value, count));
                break;

            case H2:
                ctx.visit(function(N_LSHIFT, getDataType(), value, count));
                break;



















            case HSQLDB:
                ctx.visit(imul(value, (Field<? extends Number>) castIfNeeded(DSL.power(two(), count), value)));
                break;

            default:
                ctx.sql('(').visit(value).sql(" << ").visit(count).sql(')');
                break;
        }
    }














    // -------------------------------------------------------------------------
    // The Object API
    // -------------------------------------------------------------------------

    @Override
    public boolean equals(Object that) {
        if (that instanceof Shl) {
            return
                StringUtils.equals(value, ((Shl) that).value) &&
                StringUtils.equals(count, ((Shl) that).count)
            ;
        }
        else
            return super.equals(that);
    }
}
