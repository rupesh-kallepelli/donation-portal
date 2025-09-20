{{- define "fullname" -}}
{{ .Release.Name }}-{{ .Values.appName }}
{{- end -}}
