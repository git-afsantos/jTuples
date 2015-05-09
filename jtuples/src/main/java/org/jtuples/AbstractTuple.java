/*
 * Copyright (c) 2015 git-afsantos
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jtuples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * This class provides skeletal implementations of common methods for tuples.
 *
 * @author Andre Santos <contact.andre.santos@gmail.com>
 */
public abstract class AbstractTuple implements Tuple {
    // Note that this implementation is not final.
    @Override
    public List<?> asList() {
        return Collections.unmodifiableList(Arrays.asList(this.toArray()));
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (!(obj instanceof Tuple)) { return false; }
        Tuple t = (Tuple) obj;
        if (this.arity() != t.arity()) { return false; }
        Object[] a1 = this.toArray();
        Object[] a2 = t.toArray();
        for (int i = 0; i < this.arity(); ++i) {
            if (!Objects.equals(a1[i], a2[i])) { return false; }
        }
        return true;
    }

    @Override
    public final int hashCode() {
        int hashCode = 1;
        for (Object e: this.asList()) {
            hashCode = 31 * hashCode + Objects.hashCode(e);
        }
        return hashCode;
    }

    @Override
    public final String toString() {
        StringJoiner joiner = new StringJoiner(", ", "(", ")");
        for (Object e: this.asList()) {
            joiner.add(String.valueOf(e));
        }
        return joiner.toString();
    }
}
