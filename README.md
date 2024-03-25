# Запуск в Chrome

```bash
mnv test
```

# Запуск в Firefox

```bash
mnv -Dbrowser=firefox test
```

# Если предидущий падает с ошибкой 500 то запускай этот

```bash
mnv -Dwebdriver.firefox.bin="/Program Files/Mozilla Firefox/firefox.exe" -Dbrowser=firefox test
```