[#ftl]
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Obchůdek pro mlsné jazýčky: čokoláda</title>
    <link rel="stylesheet" href="/style.css"/>
</head>
<body>
<div class="container">
    <div class="kosik">
        <h1>Objednávka</h1>
        <div>Objednávka s číslem <strong>${kod}</strong> byla vytvořena.
            [#if email?has_content]
                Na e-mail ${email} byla zaslána rekapitulace objednávky.
            [#else]
                Děkujeme za objednávku.
            [/#if]
        </div>
    </div>
</div>
</body>
</html>
