/*
 * Copyright (C) 2025  Tetex7
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.trs.qlang;

import org.jetbrains.annotations.Nullable;

import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

public class QlangInstruction implements QlangInstructionWork
{
    public static QlangInstruction of(QlangInstructionWork code)
    {
        return new QlangInstruction(code);
    }

    protected final @Nullable QlangInstructionWork getCode()
    {
        return code;
    }

    private final @Nullable QlangInstructionWork code;

    @Override
    public String work(String tag, Pattern pattern)
    {
        if (code == null)
        {
            return null;
        }
        return code.work(tag, pattern);
    }

    public QlangInstruction(@Nullable QlangInstructionWork code)
    {
        this.code = code;
    }

    @Override
    public int hashCode()
    {
        if (code != null) return code.hashCode();
        else return System.identityHashCode(this);
    }
}
