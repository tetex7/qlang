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
import org.junit.jupiter.api.Test;


public class QlangTest
{
    @Test
    void test()
    {
        final Qlang intper = Qlang.builder().includesStandardLibrary().build();
        final String test = "%mm%/%d%/%y%";
        System.out.println(intper.parse(test).outputString());
    }
}
