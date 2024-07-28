db.createUser({
    user: 'root',
    pwd: 'toor',
    roles: [
        {
            role: 'readWrite',
            db: 'testDB',
        },
    ],
});
db.createCollection('app_users', { capped: false });

db.app_users.insert([
    {
        "username": "read_laboratory",
        "dni": "VIKI771012HMCRG093",
        "enabled": true,
        "password_not_encrypted": "readonly",
        "password": "$2a$10$Ikq.8Cqlhk8K3w9azWVGZezEUK52ahXM/kJt5aqRRTJ/YYTLEUHlG",
        "role":
            {
                "granted_authorities": ["read"]
            }
    },
    {
        "username": "admin_laboratory",
        "dni": "GOTW771012HMRGR087",
        "enabled": true,
        "password_not_encrypted": "admin",
        "password": "$2a$10$sHxz/wTkEWq3nlex9C7Mg.xy5DmaTVMdiGujWUh6NU4fwwGHArXdG",
        "role":
            {
                "granted_authorities": ["read", "write"]
            }
    },
    {
        "username": "write_laboratory",
        "dni": "WALA771012HCRGR054",
        "enabled": true,
        "password_not_encrypted": "writeonly",
        "password": "$2a$10$ALCkdlxrse060884JrXOz.ZBj08YNuj7hgNbzM7ws7Sj.aZcjF8dK",
        "role":
            {
                "granted_authorities": ["write"]
            }
    }
]);