/*
 * Copyright (C) 2024  Tete
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

import com.trs.qlang.Qlang;
import com.trs.qlang.QlangInstruction;
import com.trs.qlang.QlangInstructionWork;
import com.trs.qlang.QlangString;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadFactory;
import java.util.regex.Pattern;


public class QlangTest
{
    public static class TestInst extends QlangInstruction
    {

        public TestInst()
        {
            super(null);
        }

        @Override
        public String work(String tag, Pattern pattern)
        {
            return "";
        }
    }

    @Test
    void test()
    {
        final Qlang intper = Qlang.builder().includeStandardLibrary().build();
        final QlangString test = QlangString.ofLiteral("%mm%/%d%/%y%");
        System.out.println(test);
    }
}
