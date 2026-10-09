# Step Classes — Semester 3

This repository contains Java solutions for the Semester 3 live-coding sessions and weekly assignments. Each session is kept on its own feature branch.

## Week 1 — `feature-session-1`

### Day 1 live-coding session
1. **Rock-Paper-Scissors Game** — five rounds, random computer moves, scoreboard, and win percentage.
2. **Palindrome Checker** — iterative, recursive, and array-reversal approaches.
3. **Team BMI Calculator** — BMI calculation, status classification, and formatted report.
4. **First Non-Repeating Character** — frequency counting and first unique character.
5. **Reverse Customer Name** — reverse a name while preserving the original.

### Week 1 assignment
1. **Exam Hall Seat Duplication Checker** — finds duplicate seat numbers using arrays and nested loops only.
2. **Typing Speed Test Accuracy Checker** — character-by-character comparison, accuracy, and first mismatch.
3. **Traffic Signal Streak Analyzer** — finds the longest consecutive run of a signal color.
4. **Warehouse Inventory Balancer** — compares section totals and locates the highest quantity.
5. **Movie Review Word Length Profiler** — counts short, medium, and long words.

## Week 2 — `feature-session-2`

### Day 2 live-coding session
1. **Vowel & Consonant Counter** — counts vowels and consonants, ignoring spaces.
2. **CSV Student Record Parser** — validates and formats a three-field student record.
3. **File Extension Validator** — accepts PDF, DOCX, and ZIP extensions regardless of case.
4. **Masked Phone Number Formatter** — validates a 10-digit number and masks all but the last four digits.
5. **Bank Transaction Reference Generator & Validator** — normalizes and validates a 14-character reference, then formats the date and sequence.

### Week 2 assignment
1. **ATM PIN Length Validator** — checks that a PIN contains exactly four characters, as specified in the exercise.
2. **Word Reversal Encoder** — reverses each word while keeping the word order.
3. **Product Inventory CSV Parser** — validates and formats a three-field inventory record.
4. **Library ISBN Normalizer & Validator** — validates the 13-character publisher/year/catalog format.
5. **Stop-Word-Filtered Word Frequency Report** — removes common stop words and prints remaining word counts in descending frequency order.

## Requirements

- Java 8 or later
- A terminal or Java IDE

## Compile and run

From the repository root, compile all Java files:

```bash
javac *.java
```

Run a program using its class name, for example:

```bash
java VowelConsonantCounter
java CSVStudentRecordParser
java ATMPinLengthValidator
java WordReversalEncoder
```

Each solution is a standalone Java program with a `main` method and a method matching the exercise's suggested signature where provided. Inputs are read from the console.

## Assignment details

- **Course:** Semester 3
- **Language:** Java
- **Week 1 branch:** `feature-session-1`
- **Week 2 branch:** `feature-session-2`
