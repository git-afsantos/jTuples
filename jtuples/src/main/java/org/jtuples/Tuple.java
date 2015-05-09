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

/**
 * Represents a mathematical tuple.
 * This is a fixed-length, immutable container of elements.
 * The number and type of its members are determined by the implementing
 * classes.
 *
 * @author Andre Santos <contact.andre.santos@gmail.com>
 */
public interface Tuple {
    /**
     * Returns the arity of this tuple.
     * The arity of a tuple is the number of elements it contains.
     * @return the arity of this tuple
     */
    int arity();

    /**
     * Returns a new tuple, with the same elements, in reverse order.
     * @return a tuple in reverse order
     */
    Tuple invert();

    /**
     * Compares the specified object with this tuple for equality.
     * Returns {@code true} if the specified object is also a tuple,
     * the two tuples have the same arity, and every member of the specified
     * tuple is contained in this tuple (or equivalently, every member of this
     * tuple is contained in the specified tuple). This definition ensures that
     * the {@code equals} method works properly across different implementations
     * of the tuple interface.
     * @param obj object to be compared for equality with this tuple
     * @return true if the specified object is equal to this tuple
     */
    @Override
    boolean equals(Object obj);

    /**
     * Returns the hash code value for this tuple.
     * The hash code of a tuple is defined to be the sum of the hash codes of
     * the elements in the tuple, where the hash code of a {@code null} element
     * is defined to be zero. This ensures that {@code t1.equals(t2)} implies
     * that {@code t1.hashCode()==t2.hashCode()} for any two tuples t1 and t2,
     * as required by the general contract of {@link Object#hashCode}.
     * @return the hash code value for this tuple
     */
    @Override
    int hashCode();
}
