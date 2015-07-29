# startuplib

Library for adding your Java application to startup on many different operating systems

## How it works

### Windows

Writes registry key to ```HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Run```

### OS X

Writes launch agent to ```~/Library/LaunchAgents/```

### Linux, Solaris and *BSD

Writes dekstop entry to  ```~/.config/autostart/```

## Headless systems

None yet

## Dependencies

- [oslib](https://github.com/redpois0n/oslib)
