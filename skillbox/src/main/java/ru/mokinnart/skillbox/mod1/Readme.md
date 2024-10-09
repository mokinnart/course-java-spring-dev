# Контакты

## Описание
Консольное приложение для управления контактами, которое позволяет пользователям добавлять, просматривать, удалять и сохранять информацию о контактах.

## Запуск
1. Убедитесь, что у вас установлены **JDK** и **Maven**.
2. Склонируйте репозиторий проекта и перейдите в директорию.
3. Для запуска приложения выполните команду:
   ```bash
   mvn spring-boot:run
   ```

## Команды
- `add` — Добавить новый контакт. Формат ввода: **Ф. И. О.; номер телефона; email**.
- `view` — Вывести все контакты на экран.
- `delete` — Удалить контакт, указав его **email**.
- `save` — Сохранить текущие контакты в файл.
- `exit` — Завершить работу приложения.

## Настройки
- **Файл хранения контактов**: `src/main/resources/contacts.txt` — файл, где сохраняются контакты.
- **Профиль инициализации**: используйте профиль `init`, чтобы загружать контакты из файла при старте приложения.

Пример использования:
- Для запуска с загрузкой контактов из файла выполните команду:
  ```bash
  mvn spring-boot:run -Dspring-boot.run.profiles=init
  ```