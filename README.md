## Code formatting

Use Spotless to automatically format the codebase according to the configured style rules.

```bash
./mvnw spotless:apply
```

This command:
- reformats Java files (and any other configured file types),
- updates files in place,
- helps keep formatting consistent before commit.
