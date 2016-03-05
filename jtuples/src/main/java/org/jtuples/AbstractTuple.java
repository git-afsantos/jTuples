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
import java.util.stream.Collectors;

/**
 * This class provides skeletal implementations of common methods for tuples.
 *
 * @author Andre Santos <contact.andre.santos@gmail.com>
 * @author Benjamim Sonntag <benjamimsonntag@gmail.com>
 */
public abstract class AbstractTuple implements Tuple {
    /**
     * {@inheritDoc}
     */
    @Override
    public List<?> asList() {
        return Collections.unmodifiableList(Arrays.asList(this.toArray()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        else if (!(obj instanceof Tuple)) {
            return false;
        }
        else {
            return equalsTuple((Tuple) obj);
        }
    }

    private boolean equalsTuple(Tuple other) {
        if (this.arity() != other.arity()) {
            return false;
        }
        else {
            return Arrays.equals(this.toArray(), other.toArray());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final int hashCode() {
        return this.asList().hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return this.asList().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "(", ")"));
    }
}
