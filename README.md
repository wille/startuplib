# startuplib

Library for adding your Java application to startup on many different operating systems

## How it works

### Windows

Writes registry key to ```HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Run```

### OS X

Writes [launch agent](https://developer.apple.com/library/mac/documentation/MacOSX/Conceptual/BPSystemStartup/Chapters/CreatingLaunchdJobs.html) to ```~/Library/LaunchAgents/```

### Linux, Solaris and *BSD

Writes [desktop entry](https://wiki.archlinux.org/index.php/Desktop_entries) to  ```~/.config/autostart/```

### Headless systems

None yet

## Dependencies

- [oslib](https://github.com/redpois0n/oslib)
