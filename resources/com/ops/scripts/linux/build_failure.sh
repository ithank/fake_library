#!/bin/bash +x

TEMPLATE='{"type":"message","attachments":[{"contentType":"application/vnd.microsoft.card.adaptive","contentUrl": null,"content":{"$schema": "https://adaptivecards.io/schemas/adaptive-card.json","type":"AdaptiveCard","version":"1.0","body":[{"type":"TextBlock","text": "Build Operation Completed in Failure","weight":"bolder","color":"attention","wrap": true},{"type":"TextBlock","spacing":"small","text":"[${JOB_NAME} - Build # ${BUILD_NUMBER}](${BUILD_URL})","isSubtle":false,"wrap":true},{"type":"FactSet","facts":[{"title":"Application Name:","value":"${JOB_NAME}"},{"title":"Version:","value":"${BUILD_NUMBER}"}]}]}}]}'

curl --location 'https://experityhealth.webhook.office.com/webhookb2/e3c6377c-9613-4b14-8abb-648a2764654a@5a8e2b45-25f8-40ea-a914-b466436e9417/IncomingWebhook/cf1d21e5217f4aa8aae6f0d010373d1d/70927cc2-1c47-42b5-ab1b-06840a5e3a08' \
--header 'Content-Type: application/json' \
--data "${TEMPLATE}"