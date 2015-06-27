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

import java.util.List;

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
     * Returns a new tuple, with the members shifted to the left
     * by one position. This operation has a wrapping behaviour,
     * meaning that the member that would be excluded by the shift
     * instead occupies the new open position.
     * 
     * For instance, calling {@code ((1, 2, 3)).shiftLeft()} would yield
     * the tuple {@code (2, 3, 1)}.
     * @return a tuple shifted to the left, wrapping around
     */
    Tuple shiftLeft();

    /**
     * Returns a new tuple, with the members shifted to the left
     * by one position. The given value occupies the new open position,
     * after shifting the original members.
     * 
     * For instance, calling {@code ((1, 2, 3)).shiftLeft(4)} would yield
     * the tuple {@code (2, 3, 4)}.
     * @param <V> the type of the new member to be inserted
     * @param value the new member to be inserted
     * @return a tuple shifted to the left, with the new member given
     */
    <V> Tuple shiftLeft(V value);

    /**
     * Returns a new tuple, with the members shifted to the right
     * by one position. This operation has a wrapping behaviour,
     * meaning that the member that would be excluded by the shift
     * instead occupies the new open position.
     * 
     * For instance, calling {@code ((1, 2, 3)).shiftRight()} would yield
     * the tuple {@code (3, 1, 2)}.
     * @return a tuple shifted to the right, wrapping around
     */
    Tuple shiftRight();

    /**
     * Returns a new tuple, with the members shifted to the right
     * by one position. The given value occupies the new open position,
     * after shifting the original members.
     * 
     * For instance, calling {@code ((1, 2, 3)).shiftRight(0)} would yield
     * the tuple {@code (0, 1, 2)}.
     * @param <V> the type of the new member to be inserted
     * @param value the new member to be inserted
     * @return a tuple shifted to the right, with the new member given
     */
    <V> Tuple shiftRight(V value);

    /**
     * Returns a {@code List} view of the elements in this tuple.
     * The returned list is immutable.
     * @return a list representation of this tuple
     */
    List<?> asList();

    /**
     * Returns an array containing the elements in this tuple.
     * @return an array containing the elements in this tuple
     */
    Object[] toArray();

    /**
     * Compares the specified object with this tuple for equality.
     * Returns {@code true} if the specified object is also a tuple,
     * the two tuples have the same arity, and all corresponding pairs of
     * elements in the two tuples are equal.
     * (Two elements {@code e1} and {@code e2} are equal if
     * {@code (e1 == null ? e2 == null : e1.equals(e2))}.)
     * In other words, two tuples are defined to be equal if they contain
     * the same elements in the same order.
     * This definition ensures that the {@code equals} method works properly
     * across different implementations of the {@code Tuple} interface.
     * @param obj object to be compared for equality with this tuple
     * @return true if the specified object is equal to this tuple
     */
    @Override
    boolean equals(Object obj);

    /**
     * Returns the hash code value for this tuple.
     * The hash code of a tuple is defined to be the result of the following
     * calculation.
     * <pre>{@code
     *     int hashCode = 1;
     *     for (Object e: tuple.asList())
     *         hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());}
     * </pre>
     * This ensures that {@code t1.equals(t2)} implies
     * that {@code t1.hashCode()==t2.hashCode()} for any two tuples t1 and t2,
     * as required by the general contract of {@link Object#hashCode() }.
     * @return the hash code value for this tuple
     */
    @Override
    int hashCode();

    /**
     * Returns a string representation of this tuple.
     * The string representation consists of a tuple of the tuple's elements in
     * order, enclosed in parenthesis ({@code "()"}).
     * Adjacent elements are separated by the characters {@code ", "}
     * (comma and space).
     * Elements are converted to strings as by
     * {@link String#valueOf(java.lang.Object) }.
     * @return a string representation of the tuple
     */
    @Override
    String toString();
}
