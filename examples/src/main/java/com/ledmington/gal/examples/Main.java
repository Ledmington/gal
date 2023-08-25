/*
* genetic-algorithms-library - A library for genetic algorithms.
* Copyright (C) 2023-2023 Filippo Barbari <filippo.barbari@gmail.com>
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
* along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.ledmington.gal.examples;

import java.util.Map;

public final class Main {

    private static final Map<String, Runnable> examples =
            Map.of("GeneticTsp", GeneticTsp::new, "RandomString", RandomStrings::new);

    private static void printAvailableExamples() {
        System.out.println("These are the available examples:");
        for (final String name : examples.keySet()) {
            System.out.printf(" - %s\n", name);
        }
    }

    public static void main(final String[] args) {
        if (args.length == 0) {
            printAvailableExamples();
            System.out.println("\nRerun the program with the name of the example.");
            System.exit(0);
        }

        final Runnable task = examples.get(args[0]);
        if (task == null) {
            System.out.printf("The examples '%s' does not exist.\n", args[0]);
            printAvailableExamples();
            System.exit(1);
        }

        task.run();
    }
}
