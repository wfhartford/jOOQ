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

// ...

import org.jooq.Context;
import org.jooq.Field;
import org.jooq.Param;
import org.jooq.conf.TransformUnneededArithmeticExpressions;

/**
 * @author Lukas Eder
 */
final class Neg<T> extends AbstractTransformable<T> {

    private final Field<T>               field;
    private final boolean                internal;
    private final ExpressionOperator     operator;

    Neg(Field<T> field, boolean internal, ExpressionOperator operator) {
        super(operator.toName(), field.getDataType());

        this.field = field;
        this.internal = internal;
        this.operator = operator;
    }

    @Override
    public final Field<?> transform(TransformUnneededArithmeticExpressions transform) {




















        return this;
    }

    @Override
    public final void accept0(Context<?> ctx) {





        else
            ctx.sql(operator.toSQL())
               .sql('(')
               .visit(field)
               .sql(')');
    }
}
